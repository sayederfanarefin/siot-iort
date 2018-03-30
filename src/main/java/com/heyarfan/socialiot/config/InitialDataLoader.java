package com.heyarfan.socialiot.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.heyarfan.socialiot.repository.*;



@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 

	    private Boolean testFlag = true;
	 
	 
    private boolean alreadySetup = false;

    
    
    
    @Autowired
    private ActionRepository actionRepository;


    
    @Autowired
    private ComponentRepository componentRepository;
    
    @Autowired
	private ModelRepository modelRepository;
	

    @Autowired
    private SocialGroupRepository socialGroupRepository;
    
    
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ThingRepository thingRepository;
    @Autowired
    private TrackRepository trackRepository;
    @Autowired
    private TypeRepository typeRepository;
    


    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial user
        createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<Role>(Arrays.asList(adminRole)));
        createUserIfNotFound("admin@sweetiTech.com", "Sweet", "Sweet", "Sweet", new ArrayList<Role>(Arrays.asList(adminRole)));

		if(testFlag) {
			createRandomNews(100);
			createRandomVideo(100);
			
		}
        
        
        alreadySetup = true;
    }

   

    
    @Transactional
    private final void createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        
    	System.out.println("---------------adding user init--------------");
    	try{
    		User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        
        }catch(Exception e){
        	System.out.println(e.getStackTrace());
        }
    }
    
    
    
    @Transactional
    private final void createSocialGroupIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        
    	System.out.println("---------------adding user init--------------");
    	try{
    		User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        
        }catch(Exception e){
        	System.out.println(e.getStackTrace());
        }
    }
    
    
    @Transactional
    private final void createRandomNews(int i) {
    	
    	
    	for(int x = 0; x < i ; x++) {
    		Random rand = new Random();
    		int  title = rand.nextInt(10) + 2;
    		int  sum = rand.nextInt(40) + 15;
    		int  des = rand.nextInt(100) + 50;
    		
    		String demoUrl = "https://i.ytimg.com/vi/YbAhn7iKLPc/maxresdefault.jpg";//"http://demo.wponlinesupport.com/prodemo/wp-content/uploads/2015/11/wordpress-free-news-plugin-1.jpg";
    		imageService.addImage(new Image(demoUrl));
    		Image ii = imageService.findByUrl(demoUrl);

    		
    		News news = new News(generateRandomWords(title),generateRandomWords(sum),generateRandomWords(des), imageService.findByUrl(demoUrl));

    		newsService.addNews(news);
    		
    		for(int j=0; j < 100; j++) {
    			Comment c = new Comment((long) 1, "test comment for user 1 and news" + news.getId() + "comment number: " + j, news);
        		
        		commentRepository.save(c);
    		}
    	}
    
        
    }
    
    
    public static String generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        
        StringBuilder builder = new StringBuilder();
        for(String s : randomStrings) {
        	builder.append(" ");
            builder.append(s);
        }
        String str = builder.toString();
        
       // System.out.println(str);
        return str;
    }
    
    

}