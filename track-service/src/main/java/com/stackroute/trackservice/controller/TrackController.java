package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackController {
    TrackService trackService;
    @Autowired
    public TrackController( TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * Insert track into the database
     * @Input Track to be inserted
     * @Output Newly created track
     */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)throws TrackAlreadyExistsException {

            Track savedTrack=trackService.saveTrack(track);
            return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);

    }

    /**
     * Search Track
     * @Input id Id of the track
     * @Output Track
     */
    @GetMapping("track")
    public ResponseEntity<?> getTrackById(@RequestParam int id) throws TrackNotFoundException
    {
            Track foundTrackById = trackService.getTrackById(id);
            return new ResponseEntity<>(foundTrackById, HttpStatus.FOUND);

    }

    /**
     * Delete track by ID
     * @Input  Track Id to be deleted
     * @Output Deleted Track
     */
    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrackById(@RequestParam int id)throws TrackNotFoundException {

            Track deletedTrack=trackService.deleteTrackById(id).get();
            return new ResponseEntity<>(deletedTrack,HttpStatus.OK);

    }

    /**
     * Get all tracks
     * @Output All tracks in the database
     */
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks()throws Exception {

            List<Track> listOfTracks=trackService.getAllTracks();
            return new ResponseEntity<>(listOfTracks,HttpStatus.OK);

    }

    /**
     * Update Track by Id.
     * @Input Id of the track to be updated.
     * @Input Track object containing updated track details.
     * @Output Updated track
     */
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track trackToUpdate) throws TrackNotFoundException{

            Track updatedTrack=trackService.updateTrack(trackToUpdate);
            return new ResponseEntity<>(updatedTrack,HttpStatus.OK);

    }

    /**
     * Search Track by Name.
     * @Input String  of the track name to search for.
     * @Output List of found tracks
     */
    @GetMapping("tracks/{trackName}")
    public ResponseEntity<?> selectTrackByName(@PathVariable String trackName) throws TrackNotFoundException{

            List<Track> foundTracks=trackService.selectTrackByName(trackName);
            return new ResponseEntity<>(foundTracks,HttpStatus.FOUND);

    }

}
