package com.stackroute.trackservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.GlobalResponseEntityExceptionHandler;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackServiceImpl trackService ;
    @InjectMocks
    private TrackController trackController;
    private List<Track> list = null;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).setControllerAdvice(new GlobalResponseEntityExceptionHandler()).build();
        track = new Track();
        track.setTrackId(20);
        track.setTrackName("myTrack");
        track.setComments("myTrack comments");
        list = new ArrayList<Track>();
        list.add(track);
    }
    @After
    public void tearDown() {
        track = null;
        list=null;
    }

    //    Test for saveTrack()
    @Test
    public void givenTrackShouldReturnsavedTrack() throws  Exception {

        when(trackService.saveTrack(track)).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    //    Test for saveTrackFailure
    @Test
    public void givenTrackShouldReturnSaveTrackFailure() throws Exception {
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    //    Test for getAllTracks()
    @Test
    public void MethodShouldReturnAllTracks() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }

    //    Test for getTrackById()
    @Test
    public void givenTrackIdShouldReturnFoundTrackOfThatId() throws Exception {

        when(trackService.getTrackById(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }

    //    Test for deleteTrack()
    @Test
    public void givenTrackIdShouldDeleteTrackAndReturnDeletedTrack() throws Exception {
        when(trackService.deleteTrackById(anyInt())).thenReturn(Optional.of(track));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track?id=20")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isMovedPermanently())
                .andDo(MockMvcResultHandlers.print());
    }

    //    Test for deleteTrackFailure
    @Test
    public void givenTrackIdShouldReturnTrackNotFoundException() throws Exception {
        when(trackService.deleteTrackById(anyInt())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/116")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }


    //    Test for updateTrack()
    @Test
    public void givenTrackShouldReturnUpdatedTrack() throws Exception {
        when(trackService.updateTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    //    Test for updateTrackFailure
    @Test
    public void givenTrackShouldReturnTrackNotFoundException() throws Exception {
        when(trackService.updateTrack(any())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }




    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}