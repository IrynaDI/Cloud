package service;

import org.springframework.data.domain.Pageable;
import model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.FileRepo;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepo fileRepo;

    @Transactional
    public void addFile(File file) {
        fileRepo.save(file);
    }

    @Transactional
    public void deleteFile(File file) {
       fileRepo.delete(file);
    }

    @Transactional
    public List<File> findAll(Pageable pageable) {
       return fileRepo.findAll(pageable).getContent();
    }

    @Transactional
    public File findFile(int id) {
        return fileRepo.getOne(id);
    }

    @Transactional
    public List<File> getAll(){
        return fileRepo.findAll();
    }

    @Transactional
    public long count() {
       return fileRepo.count();
    }

}
