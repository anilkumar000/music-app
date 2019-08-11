package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * TrackService Interface provides method declarations for all the operations supported
 * in the application.
 */
public interface TrackService {
     Track saveTrack(Track track) throws TrackAlreadyExistsException;
     Track getTrackById(int id) throws TrackNotFoundException;
     Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;
     List<Track> getAllTracks() throws Exception;
     Track updateTrack(Track trackToUpdate) throws TrackNotFoundException;
     List<Track> selectTrackByName(String trackName) throws TrackNotFoundException;
    }

