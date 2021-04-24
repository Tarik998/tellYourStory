package com.example.ispovjesti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/story")
public class StoryController {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @GetMapping
    public List<Story> getAllStories() {return storyRepository.findAll();}

    @GetMapping("/{id}")
    public Story getStory(@PathVariable("id") Long id){
        return storyRepository.findById(id)
                .orElseThrow(() -> new StoryNotFoundException(id));
    }

    @PutMapping("/{id}")
    public void approved (@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);
            Boolean approved = story.isApproved();
            story.setApproved(true);

            storyRepository.save(story);
        }

    @PostMapping
    public Story addStory(@RequestBody Story story) {

        return storyRepository.save(story);
    }


    @DeleteMapping("/{id}")
    void deleteStory(@PathVariable Long id) {
        storyRepository.deleteById(id);
    }

    @PutMapping("/llike/{id}")
    public void lLike(@PathVariable("id") Long id){

        Story story = storyRepository.getOne(id);

        Integer lLike = story.getLlike();
        story.setLlike(lLike+1);

        storyRepository.save(story);

    }

    @PutMapping("/ddislike/{id}")
    public void ddisike(@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);

        Integer ddislike = story.getDdislike();
        story.setDdislike(ddislike+1);

        storyRepository.save(story);


    }





}
