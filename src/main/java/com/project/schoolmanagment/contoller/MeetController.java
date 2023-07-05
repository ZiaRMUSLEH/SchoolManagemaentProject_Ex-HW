package com.project.schoolmanagment.contoller;

import com.project.schoolmanagment.payload.request.MeetRequest;
import com.project.schoolmanagment.payload.response.MeetResponse;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import com.project.schoolmanagment.service.MeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("meet")
@RequiredArgsConstructor
public class MeetController {

	private final MeetService meetService;

	@PreAuthorize("hasAnyAuthority('TEACHER')")
	@PostMapping("/save")
	public ResponseMessage<MeetResponse>saveMeet(HttpServletRequest httpServletRequest,
	                                             @RequestBody @Valid MeetRequest meetRequest){
		String username = (String) httpServletRequest.getAttribute("username");
		return meetService.saveMeet(username,meetRequest);
	}



}