package org.mk.generator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mk.generator.service.MobileKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringRunner.class)
@WebMvcTest(MobileKeyController.class)
class MobileKeyAPITest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MobileKeyService mobileKeyService;
	
	
	@Test
	public void testGetMobileKeys() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
		this.mockMvc.perform(get("/mobile_key/{mobile_nbr}?pageNbr=1&recordsPerPage=10", 1234567890)).andDo(print())
				.andExpect(status().isOk());
	}

}
