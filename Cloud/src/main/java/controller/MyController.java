package controller;

import model.File;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.FileService;

import java.io.IOException;
import java.util.List;

@Controller

public class MyController {
    static final int ITEMS_PER_PAGE = 5;

    private final FileService fileService;

    public MyController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<File> files = fileService.findAll(PageRequest.of(page,
                ITEMS_PER_PAGE,
                Sort.Direction.DESC, "id")); ;


        model.addAttribute("files", files);
        model.addAttribute("allPages", getPageCount());

        return "index";
    }

    @RequestMapping("/file_add_page")
    public String fileAddPage(){return "file_add_page";}

    @RequestMapping("/file_delete_page")
    public String fileDeletePage(Model model){
        List<File> files = fileService.getAll();
        model.addAttribute("files",files);
        return "file_delete_page";
    }

    @RequestMapping(value = "/file/add",method = RequestMethod.POST)
    public String fileAdd(@RequestParam(value = "file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            String filename = file.getOriginalFilename();
            byte[] data = file.getBytes();
            File file1 = new File(filename,data);
            fileService.addFile(file1);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "file/delete",method = RequestMethod.POST)
    public String fileDelete(@RequestParam(value="file") int id){
        File file = fileService.findFile(id);
        if(file!=null){
            fileService.deleteFile(file);
        }return "redirect:/";
    }

    private long getPageCount() {
        long totalCount = fileService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

}