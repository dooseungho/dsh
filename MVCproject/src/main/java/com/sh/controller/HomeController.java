package com.sh.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dto.BoardDTO;
import com.sh.dto.MemberDTO;
import com.sh.service.BoardService;
import com.sh.service.MemberService;

@Controller
public class HomeController {

    private final BoardService boardService;
    private final MemberService memberService;

    @Autowired
    public HomeController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        List<BoardDTO> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "contact";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/write")
    public String writePage() {
        return "write";
    }

    @PostMapping("/write")
    public String processWrite(@RequestParam String title, @RequestParam String content,
                               HttpSession session, Model model) {
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        BoardDTO newPost = new BoardDTO();
        newPost.setMember_id(loggedInUser);
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setViews(0);

        boardService.insertPost(newPost);

        model.addAttribute("successMessage", "글이 작성되었습니다!");
        return "redirect:/contact";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password,
                               HttpSession session, Model model) {
        if (memberService.isValidLogin(username, password)) { 
            session.setAttribute("loggedInUser", username);
            return "redirect:/";
        } else {
            model.addAttribute("error", "잘못되었습니다");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username, @RequestParam String password,
                                  Model model) throws UnsupportedEncodingException {
        if (isValidRegistration(username, password)) {
            MemberDTO newMember = new MemberDTO();
            newMember.setId(username);
            newMember.setPw(password);

            memberService.insertMember(newMember);

            model.addAttribute("successMessage", "회원가입을 축하드립니다!");
            return "home";
        } else {
            model.addAttribute("error", "Registration failed");
            return "register";
        }
    }

    @GetMapping("/detail/{bno}")
    public String showDetailPage(@PathVariable int bno, Model model) {
        Optional<BoardDTO> boardOptional = boardService.getBoardById(bno);
        if (boardOptional.isPresent()) {
            BoardDTO board = boardOptional.get();

            int updatedViews = board.getViews() + 1;
            board.setViews(updatedViews);
            boardService.updateBoard(board);

            model.addAttribute("board", board);
            return "detail";
        } else {
            return "redirect:/contact";
        }
    }

    @GetMapping("/edit/{bno}")
    public String showEditPage(@PathVariable int bno, Model model) {
        Optional<BoardDTO> boardOptional = boardService.getBoardById(bno);
        if (boardOptional.isPresent()) {
            BoardDTO board = boardOptional.get();
            model.addAttribute("board", board);
            return "edit";
        } else {
            return "redirect:/contact";
        }
    }

    @PostMapping("/update/{bno}")
    public String processUpdate(@PathVariable int bno, @RequestParam String title, @RequestParam String content,
                                Model model) {
        Optional<BoardDTO> boardOptional = boardService.getBoardById(bno);
        if (boardOptional.isPresent()) {
            BoardDTO board = boardOptional.get();
            board.setTitle(title);
            board.setContent(content);
            boardService.updateBoard(board);

            return "redirect:/board/" + bno;
        } else {
            return "redirect:/contact";
        }
    }

    @GetMapping("/board/{bno}")
    public String showBoardDetail(@PathVariable int bno, Model model) {
        Optional<BoardDTO> boardOptional = boardService.getBoardById(bno);
        if (boardOptional.isPresent()) {
            BoardDTO board = boardOptional.get();
            model.addAttribute("board", board);
            return "detail";
        } else {
            return "redirect:/contact";
        }
    }

    @GetMapping("/delete/{bno}")
    public String showDeletePage(@PathVariable int bno, Model model) {
        Optional<BoardDTO> boardOptional = boardService.getBoardById(bno);
        if (boardOptional.isPresent()) {
            BoardDTO board = boardOptional.get();
            model.addAttribute("board", board);
            return "delete";
        } else {
            return "redirect:/contact";
        }
    }

    @PostMapping("/delete/{bno}")
    public String processDelete(@PathVariable int bno) {
        boardService.deleteBoardById(bno);
        return "redirect:/contact";
    }

    private boolean isValidLogin(String username, String password) {
        return memberService.isValidLogin(username, password);
    }

    private boolean isValidRegistration(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        if (password == null || password.length() < 6) {
            return false;
        }

        MemberDTO existingMember = memberService.getMemberByUsername(username);
        return existingMember == null;
    }
}
