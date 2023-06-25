package com.project.schoolmanagment.contoller;

import com.project.schoolmanagment.payload.request.StudentRequest;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import com.project.schoolmanagment.payload.response.StudentResponse;
import com.project.schoolmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
	@PostMapping("/save")
	public ResponseMessage<StudentResponse>saveStudent(@RequestBody @Valid StudentRequest studentRequest){
		return studentService.saveStudent(studentRequest);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
	@GetMapping("/changeStatus")
	public ResponseMessage changeStatus (@RequestParam Long id, @RequestParam boolean status){
		return studentService.changeStatus(id,status);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
	@GetMapping("/getAll")
	public List<StudentResponse> getAllStudents(){
		return studentService.getAllStudents();
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
	@PutMapping("/update/{id}")
	public ResponseMessage<StudentResponse>updateStudent(@PathVariable Long id,
	                                                      @RequestBody @Valid StudentRequest studentRequest){
		return studentService.updateStudent(id,studentRequest);
	}


}
