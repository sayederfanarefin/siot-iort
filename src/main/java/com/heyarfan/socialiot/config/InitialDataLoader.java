//package com.heyarfan.socialiot.config;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Random;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.sweetitech.tiger.model.Comment;
//import com.sweetitech.tiger.model.Image;
//import com.sweetitech.tiger.model.News;
//import com.sweetitech.tiger.model.Privilege;
//import com.sweetitech.tiger.model.Role;
//import com.sweetitech.tiger.model.User;
//import com.sweetitech.tiger.model.Video;
//import com.sweetitech.tiger.model.VideoCategory;
//import com.sweetitech.tiger.repository.CommentRepository;
//import com.sweetitech.tiger.repository.NewsRepository;
//import com.sweetitech.tiger.repository.PrivilegeRepository;
//import com.sweetitech.tiger.repository.RoleRepository;
//import com.sweetitech.tiger.repository.UsersRepository;
//import com.sweetitech.tiger.service.IImageService;
//import com.sweetitech.tiger.service.INewsService;
//import com.sweetitech.tiger.service.IVideoCategoryService;
//import com.sweetitech.tiger.service.IVideoService;
//
//@Component
//public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//	
//	 @Autowired
//	    private PasswordEncoder passwordEncoder;
//	 
//	 @Value("${user.privilege.read}")
//	    private String  READ_PRIVILEGE;
//	 
//	 @Value("${user.privilege.write}")
//	    private String WRITE_PRIVILEGE;
//	 
//	 @Value("${user.privilege.changePassword}")
//	    private String CHANGE_PASSWORD_PRIVILEGE;
//	 
//	 @Value("${user.role.admin}")
//	    private String ROLE_ADMIN;
//	 
//	 @Value("${user.role.user}")
//	    private String ROLE_USER;
//	 
//	 
//	
//	 @Value("${spring.test.variable}")
//	    private Boolean testFlag;
//	 
//	 
//    private boolean alreadySetup = false;
//
//    
//    @Autowired
//	INewsService newsService;
//    
//    
//    @Autowired
//   	private IVideoCategoryService videoCategoryService;
//    
//    
//    @Autowired
//	private IImageService imageService;
//    
//    @Autowired
//	private IVideoService videoService;
//    
//    
//    @Autowired
//    private UsersRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//    
//    @Autowired
//    private NewsRepository newsRepository;
//    
//    @Autowired
//	CommentRepository commentRepository;
//	
//
//    @Autowired
//    private PrivilegeRepository privilegeRepository;
////
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//
//    // API
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(final ContextRefreshedEvent event) {
//        if (alreadySetup) {
//            return;
//        }
//
//        // == create initial privileges
//        final Privilege readPrivilege = createPrivilegeIfNotFound(READ_PRIVILEGE);
//        final Privilege writePrivilege = createPrivilegeIfNotFound(WRITE_PRIVILEGE);
//        final Privilege passwordPrivilege = createPrivilegeIfNotFound(CHANGE_PASSWORD_PRIVILEGE);
//
//        // == create initial roles
//        final List<Privilege> adminPrivileges = new ArrayList<Privilege>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
//        final List<Privilege> userPrivileges = new ArrayList<Privilege>(Arrays.asList(readPrivilege, passwordPrivilege));
//        final Role adminRole = createRoleIfNotFound(ROLE_ADMIN, adminPrivileges);
//        createRoleIfNotFound(ROLE_USER, userPrivileges);
//
//        // == create initial user
//        createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<Role>(Arrays.asList(adminRole)));
//        createUserIfNotFound("admin@sweetiTech.com", "Sweet", "Sweet", "Sweet", new ArrayList<Role>(Arrays.asList(adminRole)));
//
//		if(testFlag) {
//			createRandomNews(100);
//			createRandomVideo(100);
//			
//		}
//        
//        
//        alreadySetup = true;
//    }
//
//    @Transactional
//    private final Privilege createPrivilegeIfNotFound(final String name) {
//        Privilege privilege = privilegeRepository.findByName(name);
//        if (privilege == null) {
//            privilege = new Privilege(name);
//            privilege = privilegeRepository.save(privilege);
//        }
//        return privilege;
//    }
//
//    @Transactional
//    private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
//        Role role = roleRepository.findByName(name);
//        if (role == null) {
//            role = new Role(name);
//        }
//        role.setPrivileges(privileges);
//        role = roleRepository.save(role);
//        return role;
//    }
//
//    
//    @Transactional
//    private final void createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
//        
//    	System.out.println("---------------adding user init--------------");
//    	try{
//    		User user = userRepository.findByEmail(email);
//        if (user == null) {
//            user = new User();
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setPassword(passwordEncoder.encode(password));
//            user.setEmail(email);
//            user.setEnabled(true);
//        }
//        user.setRoles(roles);
//        user = userRepository.save(user);
//        
//        }catch(Exception e){
//        	System.out.println(e.getStackTrace());
//        }
//    }
//    
//    
//    @Transactional
//    private final void createRandomNews(int i) {
//    	
//    	
//    	for(int x = 0; x < i ; x++) {
//    		Random rand = new Random();
//    		int  title = rand.nextInt(10) + 2;
//    		int  sum = rand.nextInt(40) + 15;
//    		int  des = rand.nextInt(100) + 50;
//    		
//    		String demoUrl = "https://i.ytimg.com/vi/YbAhn7iKLPc/maxresdefault.jpg";//"http://demo.wponlinesupport.com/prodemo/wp-content/uploads/2015/11/wordpress-free-news-plugin-1.jpg";
//    		imageService.addImage(new Image(demoUrl));
//    		Image ii = imageService.findByUrl(demoUrl);
//
//    		
//    		News news = new News(generateRandomWords(title),generateRandomWords(sum),generateRandomWords(des), imageService.findByUrl(demoUrl));
//
//    		newsService.addNews(news);
//    		
//    		for(int j=0; j < 100; j++) {
//    			Comment c = new Comment((long) 1, "test comment for user 1 and news" + news.getId() + "comment number: " + j, news);
//        		
//        		commentRepository.save(c);
//    		}
//    	}
//    
//        
//    }
//    
//    
//    public static String generateRandomWords(int numberOfWords)
//    {
//        String[] randomStrings = new String[numberOfWords];
//        Random random = new Random();
//        for(int i = 0; i < numberOfWords; i++)
//        {
//            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
//            for(int j = 0; j < word.length; j++)
//            {
//                word[j] = (char)('a' + random.nextInt(26));
//            }
//            randomStrings[i] = new String(word);
//        }
//        
//        StringBuilder builder = new StringBuilder();
//        for(String s : randomStrings) {
//        	builder.append(" ");
//            builder.append(s);
//        }
//        String str = builder.toString();
//        
//       // System.out.println(str);
//        return str;
//    }
//    
//    
//    
//    
//    
//    @Transactional
//    private final void createRandomVideo(int i) {
//    	
//    	
//    
//    	createVideoCategoryIfNotFound("Vimeo");
//    	VideoCategory vc = createVideoCategoryIfNotFound("YouTube");
//    	
//    	for(int x = 0; x < i ; x++) {
//    		Random rand = new Random();
//    		int  title = rand.nextInt(10) + 2;
//    		int  des = rand.nextInt(100) + 50;
//    		
//    		int urlNum = rand.nextInt(7);
//    		
//    		String [] demoUrls = {
//    				"https://www.youtube.com/watch?v=_BFXCgm5270",
//    				"https://www.youtube.com/watch?v=_qy4s3F9P6I",
//    				"https://www.youtube.com/watch?v=Ij99dud8-0A",
//    				"https://www.youtube.com/watch?v=SyRHeyFdl0I",
//    				"https://www.youtube.com/watch?v=SbWeP7KkeCU",
//    				"https://www.youtube.com/watch?v=a8Z2jSATjqQ",
//    				"https://www.youtube.com/watch?v=WxnN05vOuSM",
//    				"https://www.youtube.com/watch?v=h8IuFl3sMhk"
//    				
//    		};
//    		
//    		//String demoUrl = "https://www.youtube.com/watch?v=_BFXCgm5270";//"http://demo.wponlinesupport.com/prodemo/wp-content/uploads/2015/11/wordpress-free-news-plugin-1.jpg";
//    		
//    		Video video = new Video(generateRandomWords(title),demoUrls[urlNum],generateRandomWords(des), vc);
//
//    		videoService.addVideo(video);
//    		
//    	}
//    
//    	
//        
//    }
//    
//    
//    @Transactional
//    private final VideoCategory createVideoCategoryIfNotFound(final String category) {
//        
//    	System.out.println("---------------adding video category init--------------");
//    	try{
//    		
//    		
//    		
//    		VideoCategory videoCategory = videoCategoryService.findByName(category);
//    		
//    		if(videoCategory == null) {
//    			
//    			videoCategory = new VideoCategory(category);
//    			videoCategoryService.addVideoCategory(videoCategory);
//    		}
//        
//    		
//    		return videoCategory;
//        }catch(Exception e){
//        	System.out.println(e.getStackTrace());
//        	
//        	return null;
//        }
//    }
//    
//
//}