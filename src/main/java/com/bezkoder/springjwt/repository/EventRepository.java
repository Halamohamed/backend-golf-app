package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    //@Query("from Event e where not(e.end < : from or e.start > :to)")
    public List<Event> findEventsByStartAfterAndEndBefore(@Param("from") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime start, @Param("to") LocalDateTime end);
}
