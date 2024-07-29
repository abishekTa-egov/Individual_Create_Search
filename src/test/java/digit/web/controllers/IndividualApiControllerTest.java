package digit.web.controllers;

import digit.web.models.ErrorRes;
import digit.web.models.IndividualBulkRequest;
import digit.web.models.IndividualBulkResponse;
import digit.web.models.IndividualBulkSearchResponse;
import digit.web.models.IndividualRequest;
import digit.web.models.IndividualResponse;
import digit.web.models.IndividualSearchRequest;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import digit.TestConfiguration;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* API tests for IndividualApiController
*/
@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(IndividualApiController.class)
@Import(TestConfiguration.class)
public class IndividualApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void individualV1BulkCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1BulkCreatePostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void individualV1BulkDeletePostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1BulkDeletePostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void individualV1BulkUpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1BulkUpdatePostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void individualV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void individualV1DeletePostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1DeletePostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void individualV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void individualV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/individual/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void individualV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/individual/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

}
