package com.example.spingDataJpa.springDataJpaTutorial.reposTest;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Answer;
import com.example.spingDataJpa.springDataJpaTutorial.entity.CompositKey;
import com.example.spingDataJpa.springDataJpaTutorial.entity.Ques;
import com.example.spingDataJpa.springDataJpaTutorial.entity.Users;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.AnswerRepo;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.QuestionRepo;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuesRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Test
    public void addQues(){
        Ques ques=Ques.builder()
                .ques("Whats is your Fname")
                .answer("Divakar Pal")
                .build();
        questionRepo.save(ques);
    }

    @Test
    public void addUser(){
        Users users=Users.builder()
                .name("Monu Pal")
                .build();
        userRepo.save(users);
    }

    @Test
    public void saveAnswer(){
        Users users=userRepo.findById(Long.parseLong("1")).orElse(null);
        Ques ques=questionRepo.findById(Long.parseLong("2")).orElse(null);
        answerRepo.save(Answer.builder()
                        .compositKey(CompositKey.builder()
                                .quesId(4)
                                .usersId(2)
                                .build())
                        .userAnswer("mama ji")
                .build());
    }

    @Test
    public void searchById(){
        Answer answer= answerRepo.findById(CompositKey.builder().quesId(1).usersId(2).build()).orElse(null);
        System.out.println(answer);
    }
}
