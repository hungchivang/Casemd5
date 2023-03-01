package com.be_casemodule5.service;

import com.be_casemodule5.model.Image;
import com.be_casemodule5.repo.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageService {
    @Autowired
    IImageRepo iImageRepo;

    public List<Image> getAll() {
        return (List<Image>) iImageRepo.findAll();
    }


    public Image save(Image image) {
        return iImageRepo.save(image);
    }

    public void delete(long id) {
        iImageRepo.delete(iImageRepo.findImageById(id));
    }

}
