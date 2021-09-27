package ironhack.midterm.BankingSystem.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironhack.midterm.BankingSystem.dao.accounts.Checking;
import ironhack.midterm.BankingSystem.dao.accounts.CreditCard;
import ironhack.midterm.BankingSystem.dao.accounts.Money;
import ironhack.midterm.BankingSystem.dao.accounts.Savings;
import ironhack.midterm.BankingSystem.dao.users.AccountHolder;
import ironhack.midterm.BankingSystem.dao.users.Address;
import ironhack.midterm.BankingSystem.dao.users.Admin;
import ironhack.midterm.BankingSystem.enums.AccountStatus;
import ironhack.midterm.BankingSystem.repository.accountsRepository.SavingsRepository;
import ironhack.midterm.BankingSystem.repository.usersRepository.AdminRepository;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.datatype.joda.JodaModule;

@SpringBootTest
public class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private SavingsRepository savingsRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JodaModule());

    private Admin admin;
    private Checking checking;
    private AccountHolder accountHolder;
    private Savings savings;
    private CreditCard creditCard;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        admin = new Admin("Administrator");
        adminRepository.save(admin);
    }

    @AfterEach
    public void tearDown(){
        adminRepository.deleteAll();
    }

    @Test
    public void create_Checking_Account() throws Exception{
        checking = new Checking(new Money(new BigDecimal(500),"USD"), "John Smith", "String secretKey", AccountStatus.ACTIVE);
        accountHolder = new AccountHolder("Adam", "Kowalski", "ABW123123", LocalDate.now().minusYears(25), new Address("GB", "London", "Trafalgar Square", "26/2"));

        String body = objectMapper.writeValueAsString(checking);
        String body2 = objectMapper.writeValueAsString(accountHolder);
        MvcResult result = mockMvc.perform(
                post("/checking")
                        .content(body)
                        .content(body2)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("John"));
    }

    @Test
    public void create_Savings_Account() throws Exception{
        savings = new Savings(new Money(BigDecimal.valueOf(80000),"GBP"), "X-men", "!",AccountStatus.FROZEN);

        String body = objectMapper.writeValueAsString(savings);
        MvcResult result = mockMvc.perform(
                post("/savings")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("X-men"));
    }

    @Test
    public void create_CreditCard_Account() throws Exception{
        creditCard = new CreditCard(new Money(BigDecimal.valueOf(43.43),"EUR"), "Peggy Sue");

        String body = objectMapper.writeValueAsString(creditCard);
        MvcResult result = mockMvc.perform(
                post("/creditcard")
                    .content(body)
                    .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Peggy"));
    }
}
