package com.heyarfan.socialiot.controller;

import java.awt.Image;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heyarfan.socialiot.model.Thing;
import com.heyarfan.socialiot.service.interfaces.IThingService;


@RestController
@RequestMapping("/thing")
public class ThingController {


	
	@Autowired
	private IThingService thingService;

	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Thing> addThing(@Valid Principal principal,


			@RequestParam("title") String title, 
			@RequestParam("description") String description, @RequestParam("imageId") long imageId) {
				return null;
		
		
		

//		if(hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
//			Image image = imageService.findById(imageId);
//			
//			GalleryImage galleryImage = galleryImageService.addGalleryImage(new GalleryImage(title, description, image));
//			
//			
//			return new ResponseEntity(galleryImage, HttpStatus.OK);
//		}else {
//			return new ResponseEntity("You do not have the permission to do so", HttpStatus.FORBIDDEN);
//		}

	}
	
	
	// returns lastest PAGE_SIZE number of galleryImag
//	@GetMapping("/")
//	public @ResponseBody Page<Thing> showAllGalleryImage() {
//
//		Page<Thing> galleryImageList = thingService.findAllGalleryImage(0);
//		return galleryImageList;
//	}

	

	@GetMapping("/id")
	public @ResponseBody Thing showGalleryImage(@RequestParam("id") Long id) {

		Thing galleryImage = thingService.findById(id);
		if (galleryImage != null) {
			return galleryImage;
		} else {

			return null;
		}

	}

	
}