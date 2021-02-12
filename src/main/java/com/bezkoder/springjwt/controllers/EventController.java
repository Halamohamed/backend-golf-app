package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Event;
import com.bezkoder.springjwt.repository.EventRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/calendar")
public class EventController {
    @Autowired
    EventRepository repository;

    @GetMapping("/events")
    public ResponseEntity<Iterable<Event>> events(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime start,
                                                  @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end){
        return ResponseEntity.ok(repository.findEventsByStartAfterAndEndBefore(start,end));
    }

    @PostMapping("/events/create")
    @JsonSerialize(using = LocalDateSerializer.class)
    @Transactional
    public ResponseEntity<Event> createEvent(@RequestBody EventCreateParams params){
        Event event = new Event();
        event.setStart(params.start);
        event.setEnd(params.end);
        event.setText(params.text);
        repository.save(event);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/events/move")
    @JsonSerialize(using = LocalDateSerializer.class)
    @Transactional
    public Event moveEvent(@RequestBody EventMoveParams params){
        Event event = repository.findById(params.id).get();
        event.setStart(params.start);
        event.setEnd(params.end);
        repository.save(event);
        return event;
    }

    @PostMapping("/events/setColor")
    @JsonSerialize(using = LocalDateSerializer.class)
    @Transactional
    public Event setColor(@RequestBody SetColorParams params) {
        Event event = repository.findById(params.id).get();
        event.setColor(params.color);
        repository.save(event);
        return event;
    }

    public static class EventCreateParams {

        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
        public Long resource;
    }
    public static class EventMoveParams {
        public Long id;
        public LocalDateTime start;
        public LocalDateTime end;
        public Long resource;
    }
    public static class SetColorParams {
        public Long id;
        public String color;
    }


}
