package com.ifmt.seedlingNursery.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.IrrigationTime;
import com.ifmt.seedlingNursery.Service.IrrigationTimeService;

import lombok.AllArgsConstructor;

@CrossOrigin(exposedHeaders = { "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials" })
@AllArgsConstructor
@RestController
@RequestMapping("/irrigation-time")
public class IrrigationTimeController {
  IrrigationTimeService irrigationTimeService;

  @PostMapping("/valve/{valveId}")
  public ResponseEntity<IrrigationTime> saveIrrigationTime(@RequestBody IrrigationTime irrigationTime,
      @PathVariable Long valveId) {
    return new ResponseEntity<IrrigationTime>(irrigationTimeService.saveTime(irrigationTime, valveId),
        HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<IrrigationTime> getIrrigationTime(@PathVariable Long id) {
    return new ResponseEntity<IrrigationTime>(irrigationTimeService.getTime(id), HttpStatus.OK);
  }

  @GetMapping("/valve/{valveId}")
  public ResponseEntity<List<IrrigationTime>> getTimeByValve(@PathVariable Long valveId) {
    return new ResponseEntity<List<IrrigationTime>>(irrigationTimeService.getTimesByValve(valveId), HttpStatus.OK);
  }

  @GetMapping("/is-on/{valveId}")
  public ResponseEntity<Boolean> isValveOn(@PathVariable Long valveId) {
    return new ResponseEntity<Boolean>(irrigationTimeService.isValveOn(valveId), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<HttpStatus> deleteValve(@PathVariable Long id) {
    irrigationTimeService.deleteByiD(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
