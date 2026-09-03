package com.muslimapp.muslimdailycompanion.controller;

import com.muslimapp.muslimdailycompanion.entity.FriendRequest;
import com.muslimapp.muslimdailycompanion.repository.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/friend-requests")
public class FriendRequestController {

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @PostMapping
    public FriendRequest sendRequest(@RequestBody FriendRequest request) {
        return friendRequestRepository.save(request);
    }

    @GetMapping("/pending/{userId}")
    public List<FriendRequest> getPendingRequests(@PathVariable Long userId) {
        return friendRequestRepository.findByReceiverIdAndStatus(userId, "PENDING");
    }

    @PutMapping("/{id}/accept")
    public FriendRequest acceptRequest(@PathVariable Long id) {
        FriendRequest request = friendRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("ACCEPTED");
        return friendRequestRepository.save(request);
    }

    @PutMapping("/{id}/decline")
    public FriendRequest declineRequest(@PathVariable Long id) {
        FriendRequest request = friendRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("DECLINED");
        return friendRequestRepository.save(request);
    }
}