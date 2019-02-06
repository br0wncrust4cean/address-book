package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuddyInfoTest {
    @Autowired
    private BuddyInfoRepository repo;

    @Autowired
    private MockMvc mockMvc;
    private String testJson;

    @Before
    public void setup() {
        this.testJson =
                "{\n" +
                "\t\"name\":\"Bhavik\",\n" +
                "\t\"phoneNumber\":\"1-800-222-2222\"\n" +
                "}";
    }

    @Test
    public void addBuddy() throws Exception {
        this.mockMvc
                .perform(post("/buddy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testJson)
                        .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isCreated());
    }

    @Test
    public void getBuddy() throws Exception {
        this.mockMvc
                .perform(get("/buddy/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
