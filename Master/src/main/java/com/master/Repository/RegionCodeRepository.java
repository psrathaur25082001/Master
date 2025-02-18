package com.master.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.master.entity.RegionCode;

@Repository  // Make sure this annotation is present
public interface RegionCodeRepository extends JpaRepository<RegionCode, Long> {
}
