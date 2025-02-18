

package com.master.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.Repository.RegionCodeRepository;
import com.master.entity.RegionCode;
@Service
public class RegionCodeService {

	 @Autowired
	    private RegionCodeRepository regionCodeRepository;

	    // Save a new region
	    public RegionCode saveRegion(RegionCode region) {
	        region.setCreatedDate(LocalDateTime.now());
	        region.setModifiedDate(LocalDateTime.now());
	        return regionCodeRepository.save(region);
	    }

	    // Get all regions
	    public List<RegionCode> getAllRegions() {
	        return regionCodeRepository.findAll();
	    }

	    // Get region by ID
	    public Optional<RegionCode> getRegionById(Long id) {
	        return regionCodeRepository.findById(id);
	    }

	    // Update an existing region
	    public RegionCode updateRegion(Long id, RegionCode updatedRegion) {
	        return regionCodeRepository.findById(id).map(region -> {
	            region.setRegionName(updatedRegion.getRegionName());
	            region.setRegionCode(updatedRegion.getRegionCode());
	            region.setAdditionalInfo(updatedRegion.getAdditionalInfo());
	            region.setModifiedBy(updatedRegion.getModifiedBy());
	            region.setModifiedDate(LocalDateTime.now());
	            return regionCodeRepository.save(region);
	        }).orElse(null);
	    }

	    // Delete a region by ID
	    public boolean deleteRegion(Long id) {
	        if (regionCodeRepository.existsById(id)) {
	            regionCodeRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	
}
