package com.techproed.springmvctutorial;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {

	//1.Way
	//	@RequestMapping("add")
	//	public String addNums1(HttpServletRequest req) {
	//		
	//		int a = Integer.parseInt(req.getParameter("n1"));
	//		int b = Integer.parseInt(req.getParameter("n2"));
	//		int sum = a + b;
	//		int product = a * b;
	//		
	//		HttpSession session = req.getSession();
	//		session.setAttribute("sumOfTwoIntegers", sum);
	//		session.setAttribute("productOfTwoIntegers", product);
	//		
	//		return "result";
	//		
	//	}

	//2.Way
	@RequestMapping("add")
	public String addNums2(@RequestParam("n1") int a, @RequestParam("n2") int b, HttpSession session) {

		int sum = a + b;
		int product = a * b;

		session.setAttribute("sumOfTwoIntegers", sum);
		session.setAttribute("productOfTwoIntegers", product);

		return "result";

	}

	//3.Way
	//First way of using ModelAndView
	//		@RequestMapping("add")
	//		public ModelAndView addAndMultiplyNums3(@RequestParam("n1") int a, @RequestParam("n2") int b) {
	//			
	//			ModelAndView mv = new ModelAndView();
	//			mv.setViewName("result");
	//			
	//			int sum = a + b;
	//			int product = a * b;
	//			
	//			mv.addObject("sumOfNumbers", sum);
	//			mv.addObject("productOfNumbers", product);
	//			
	//			return mv;
	//		}

	//4.Way
	//Second way of using ModelAndView (Recommended)
	//		@RequestMapping("add")
	//		public ModelAndView addAndMultiplyNums4(@RequestParam("n1") int a, @RequestParam("n2") int b) {
	//			
	//			ModelAndView mv = new ModelAndView("result");
	//			
	//			int sum = a + b;
	//			int product = a * b;
	//			
	//			mv.addObject("sumOfNumbers", sum);
	//			mv.addObject("productOfNumbers", product);
	//			
	//			return mv;
	//		}

	//5.Way
	//		@RequestMapping("add")
	//		public String addAndMultiplyNums5(@RequestParam("n1") int a, @RequestParam("n2") int b, Model m) {
	//			
	//			int sum = a + b;
	//			int product = a * b;
	//			
	//			//First usage
	////			m.addAttribute("sumOfNumbers", sum);
	////			m.addAttribute("productOfNumbers", product);
	//			
	//			//Second usage
	//			m.addAttribute("sumOfNumbers", sum)
	//			 .addAttribute("productOfNumbers", product);
	//
	//			return "result";
	//		}

	//6.Way
	//		@RequestMapping("add")
	//		public String addAndMultiplyNums6(@RequestParam("n1") int a, @RequestParam("n2") int b, ModelMap mm) {
	//			
	//			int sum = a + b;
	//			int product = a * b;
	//			
	//			//First usage
	////			mm.addAttribute("sumOfNumbers", sum);
	////			mm.addAttribute("productOfNumbers", product);
	//			
	//			//Second usage
	//			mm.addAttribute("sumOfNumbers", sum)
	//			 .addAttribute("productOfNumbers", product);
	//
	//			return "result";
	//		}


	//#########################################################

	//1st Way
	//	@RequestMapping("addStudent")
	//	public String addStudent(@RequestParam("id") int id, @RequestParam("name") String name, Model m) {
	//		//First Way
	//		Student student = new Student();
	//
	//		student.setId(id);
	//		student.setName(name);
	//
	//		//2nd way
	//		Student student1 = new Student(id,name);
	//
	//		m.addAttribute("studentObject", student);
	//		m.addAttribute("studentObject1",student1);
	//
	//
	//		return "result";
	//	}

	//2.nd Way How to use: ModelAttribute Annotation 
	//	@RequestMapping("addStudent")
	//	public String addStudent2(@ModelAttribute Student student, Model m) {
	//
	//		m.addAttribute("studentObject", student);
	//
	//		return "result";
	//	}

	//3Way

	@RequestMapping("addStudent")
	public String addStudent2(@ModelAttribute("studentObject") Student student) {

		//m.addAttribute("studentObject", student);

		return "result";
	}

	//How to get a specific field from an object==> use @ModelAttribute 
	@ModelAttribute
	public void greetStudent(Model m , Student student) {
		m.addAttribute("GreetStudent", student.getName());
		m.addAttribute("StudentID",student.getId());

	}

	//in HTTP methods, there are some methods we need to know,
	/*
	 *1)Get  Request
	 *2)Post   Request == used to create new data
	 *3)Put 
	 *4)Delete
	 *5)Patch
Get : enables you to retrieve data from server
Post: enables you to add data to an existing
     file or resource in a server
Put: lets you replace an existing file or resource
     in a server
Delete: lets you delete data from server
Patch: For partial update
	 *
	 *
	 */
	//######   how to use POST method
	//1st Way:
	// 1--inside the method parenthesis type :==> "method = RequestMethod.POST"
	// 2--and inside the index.jps file add :==> "method = "post"  inside the form tag
	//	@RequestMapping(value="addStudent",method = RequestMethod.POST)
	//	public String addStudent3(@ModelAttribute("studentObject") Student student) {
	//
	//
	//
	//		return "result";
	//	}
	//	@ModelAttribute
	//	public void greetStudent1(Model m , Student student) {
	//		m.addAttribute("GreetStudent", student.getName());
	//		m.addAttribute("StudentID",student.getId());
	//
	//	}


	//2nd Way :
	//1) Use PostMapping with action name ==> @PostMapping(value="addStudent")
	//2) got to index.jps file and add ===and inside the index.jps file add :==> "method = "post"  inside the form tag
	@PostMapping(value="addStudent")
	public String addStudent3(@ModelAttribute("studentObject") Student student) {

		return "result";
	}
	@ModelAttribute
	public void greetStudent1(Model m , Student student) {
		m.addAttribute("GreetStudent", student.getName());
		m.addAttribute("StudentID",student.getId());

	}

	//------------HOW TO USE GET METHOD-------
	// 1--inside the method parenthesis type :==> "method = RequestMethod.GET"
	// 2--and inside the index.jps file add :==> "method = "get"  inside the form tag
	//3 Got to result.jps file and type ==> ${studentList}

	@RequestMapping(value = "getStudent", method = RequestMethod.GET)
	public String getStudent(Model m, Student student) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(101,"Ali Can") );
		students.add(new Student(102,"Veli Han") );
		students.add(new Student(103,"Mary Star") );
		students.add(new Student(104,"Tom Hanks") );
		students.add(new Student(105,"Angie Ocean") );

		m.addAttribute("studentList",students);

		return "result";
	}

	//2nd Way

	@GetMapping("getStudent1" )
	public String getStudent1(Model m, Student student) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1001,"Deli Kan") );
		students.add(new Student(1002,"Amir Khan") );
		students.add(new Student(1003,"Mary Star") );
		students.add(new Student(1004,"Tom Hanks") );
		students.add(new Student(1005,"Angie Ocean") );

		m.addAttribute("studentList1",students);

		return "result";
	}

}