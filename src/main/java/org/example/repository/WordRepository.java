package org.example.repository;

import org.example.dto.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class WordRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addWord(Word word1) {
        String sql = "insert into word (word,translate,description)values(?,?,?)";
        int resultSet = jdbcTemplate.update(sql, word1.getWord(), word1.getTranslate(), word1.getDescription());
        return resultSet >= 1;
    }
    public List<Word> wordList() {
        String sql="select * from word";
        List<Word>wordsList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Word.class));
        return wordsList;
    }
    public boolean deletewordById(int id){
        String sql="delete from word where  id="+id;
        int result= jdbcTemplate.update(sql);
        return result>=1;
    }
    public List<Word> randomlist(int ran) {
        String sql="select * from word where id="+ran;
        List<Word>wordsList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Word.class));
        return wordsList;
    }
}