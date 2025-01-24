package com.example.room_service.controller;

import com.example.room_service.dto.AssetDTO;
import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.service.AssetService;
import com.example.room_service.service.AssetServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AssetController {
    AssetService assetService;

    @PostMapping("/add")
    public ResponseEntity<AssetDTO> addAsset(@RequestBody AssetRequest request) {
        return ResponseEntity.ok(assetService.createAsset(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<AssetDTO>> getAssetList() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<AssetDTO> getAssetById(@PathVariable("id") String id) {
        return ResponseEntity.ok(assetService.getAssetById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AssetDTO> updateAsset(@PathVariable("id") String id, @RequestBody AssetRequest request) {
        return ResponseEntity.ok(assetService.updateAsset(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable("id") String id) {
        assetService.deleteAsset(id);
        return ResponseEntity.ok("Deleted asset" + id);
    }
}
