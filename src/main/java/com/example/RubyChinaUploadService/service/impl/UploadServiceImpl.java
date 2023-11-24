package com.example.RubyChinaUploadService.service.impl;

import com.example.RubyChinaUploadService.dao.ApplicationRepository;
import com.example.RubyChinaUploadService.dao.BlogRepository;
import com.example.RubyChinaUploadService.dao.DeploymentRepository;
import com.example.RubyChinaUploadService.dao.FeatureRepository;
import com.example.RubyChinaUploadService.dao.RubyRepository;
import com.example.RubyChinaUploadService.dao.ToolRepository;
import com.example.RubyChinaUploadService.entity.ApplicationNode;
import com.example.RubyChinaUploadService.entity.Blog;
import com.example.RubyChinaUploadService.entity.Ruby;
import com.example.RubyChinaUploadService.entity.Tool;
import com.example.RubyChinaUploadService.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private RubyRepository rubyRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private DeploymentRepository deploymentRepository;

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void upload(String dir, int count, String nodeName, String type) {
        // Ruby
        Ruby ruby = rubyRepository.findByName("Ruby");
        Random rand = new Random();
        for (int i = 1; i <= count; i++) {
            String fileName = dir + i + ".txt";
            try {
                List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
                Blog blog = new Blog();
                blog.setTitle(lines.get(0));
                blog.setTime(lines.get(1));
                lines.subList(0, 3).clear();
                blog.setContent(String.join(System.lineSeparator(), lines));
                blog.setType(type);
                if (i < 18){
                    blog.setSentiment("positive");
                    blog.setExcellent(true);
                }
                else {
                    blog.setSentiment("neutral");
                    int r = rand.nextInt(150);
                    if (r < 10){
                        blog.setSentiment("negative");
                    }
                }

                ruby.getBlogs().add(blog);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        blogRepository.saveAll(ruby.getBlogs());
        rubyRepository.save(ruby);
    }
}
