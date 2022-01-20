package pl.pjatk.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookRestControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_exampleBook() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/book/example");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"title\":\"exampleTitle\",\"isbn\":\"exampleISBN\",\"publisher\":{\"id\":1,\"name\":\"exampleName\",\"address\":\"exampleAddress\",\"city\":\"exampleCity\",\"books\":[1]},\"authors\":[{\"id\":1,\"firstName\":\"exampleFname\",\"lastName\":\"exampleLname\",\"books\":[1]},1]}"));
    }

    @Test
    void shouldReturnSuccess_exampleWithTitle() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/book/exampleWithTitle").param("title", "EXAMPLE_TITLE");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":null,\"title\":\"EXAMPLE_TITLE\",\"isbn\":\"exampleISBN\",\"publisher\":null,\"authors\":null}"));
    }
}
