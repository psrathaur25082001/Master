package com.master.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.Service.RegionCodeService;
import com.master.entity.RegionCode;

@RestController

public class RegionCodeController {

	 @Autowired
	    private RegionCodeService regionCodeService;

	    // Create a new region
	    @PostMapping("/add")
	    public ResponseEntity<RegionCode> createRegion(@RequestBody RegionCode region) {
	        return ResponseEntity.ok(regionCodeService.saveRegion(region));
	    }

	    // Get all regions
	    @GetMapping("/all")
	    public ResponseEntity<List<RegionCode>> getAllRegions() {
	        return ResponseEntity.ok(regionCodeService.getAllRegions());
	    }

	    // Get a region by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<RegionCode> getRegionById(@PathVariable Long id) {
	        Optional<RegionCode> region = regionCodeService.getRegionById(id);
	        return region.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Update a region
	    @PutMapping("/update/{id}")
	    public ResponseEntity<RegionCode> updateRegion(@PathVariable Long id, @RequestBody RegionCode updatedRegion) {
	        RegionCode region = regionCodeService.updateRegion(id, updatedRegion);
	        return (region != null) ? ResponseEntity.ok(region) : ResponseEntity.notFound().build();
	    }

	    // Delete a region
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteRegion(@PathVariable Long id) {
	        return regionCodeService.deleteRegion(id) ?
	               ResponseEntity.ok("Region deleted successfully.") :
	               ResponseEntity.notFound().build();
	    }
}
