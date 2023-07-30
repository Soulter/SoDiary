package top.soulter.sodiary;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import top.soulter.sodiary.domain.Diary;

@SpringBootTest()
//@AutoConfigureMockMvc
@Slf4j
class SoDiaryApplicationTests {
    @Test
    void contextLoads() throws Exception {

//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/diary/fetch?page=1&size=10");
//        ResultActions actions = mockMvc.perform(builder);
//        ContentResultMatchers content = MockMvcResultMatchers.content();
//        ResultMatcher expectRes = content.json("[]");
//        actions.andExpect(expectRes);
//        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("test", "testVal");
//        log.info((String) ops.get("test"));
//
//        HashOperations ops2 = redisTemplate.opsForHash();
//        ops2.put("test2", "test2", "test2Val");
//        log.info((String) ops2.get("test2", "test2"));

//        Diary diary = new Diary();
//        diary.setContent("hahaha");
//        diary.setTime("2022");
//        diary.setTitle("tttitle");
//        diary.setId(2);
//        mongoTemplate.save(diary);
//        System.out.println(mongoTemplate.findAll(Diary.class));
    }

}
