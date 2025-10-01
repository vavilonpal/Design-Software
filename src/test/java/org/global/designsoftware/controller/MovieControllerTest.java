package org.global.designsoftware.controller;

import org.global.designsoftware.config.FieldMaskConfiguration;
import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.printer.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
@Import({FieldMaskConfiguration.class, MovieRepository.class})
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;


    @Test
    void getMovieByTitle_usesRealRepositoryAndMasks() throws Exception {
        mockMvc.perform(get("/api/v1/movie/Inception"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.director").value("Christopher Nolan"))
                .andExpect(jsonPath("$.genre").value("ACTION"));
    }

    @Test
    void copyDataByTitleEqualsMaskAndCopyMask() throws Exception {
        String jsonMovie = """
                {
                  "id": 42,
                  "title": "Inception",
                  "director": "Christopher Nolan",
                  "fees": 123.4,
                  "genre": "ACTION"
                }
                """;

        mockMvc.perform(put("/api/v1/movie/copy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMovie))
                .andExpect(status().isOk())
                .andExpect(content().string("Successful copy!!"));

        Movie updated = movieRepository.findByName("Inception");
        assert updated.getDirector().equals("Christopher Nolan");
        assert updated.getFees().equals(123.4f);
    }
}
