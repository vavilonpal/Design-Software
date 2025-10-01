package org.global.designsoftware;

import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.enums.Genre;
import org.global.designsoftware.printer.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesignSoftwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignSoftwareApplication.class, args);
    }

}
