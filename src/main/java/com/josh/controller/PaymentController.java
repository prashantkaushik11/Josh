package com.josh.controller;

import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.HTTPException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;
import com.josh.model.Kabaddi;
import com.josh.model.Student;
import com.josh.model.TransactionDetails;
import com.josh.service.PaymentService;
import com.josh.service.StudentService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/newPayment")
    public String newPayment(@AuthenticationPrincipal User activeUser, Model model){
        Student student = studentService.getStudentByUsername(activeUser.getUsername());
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setName(student.getUsername());
        transactionDetails.setPhoneNo(student.getStudentPhone());
        transactionDetails.setEmail(student.getStudentEmail());
        model.addAttribute("transactionalDetail", transactionDetails);
        return "paymentHome";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String paymentSuccess(@RequestParam Map<String,String> allParams, Model model){
        model.addAttribute("payment_id", allParams.get("payment_id"));
        model.addAttribute("payment_status", allParams.get("payment_status"));
        model.addAttribute("transaction_id", allParams.get("transaction_id"));
        return "success";
    }

    @RequestMapping(value = "/newPayment", method = RequestMethod.POST)
    public String newPaymentPost(@Valid @ModelAttribute("transactionalDetail") TransactionDetails transactionDetail, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response){
       if(result.hasErrors()) {
           model.addAttribute("transactionalDetail", transactionDetail);
           return "paymentHome";
       }

        ApiContext context = ApiContext.create("test_GxO93jrCiz2GGP5c4Hz4TI82fFroq6CZso5", "test_bv145b89sFl0f5p7rN2Qo3WURfUucsSzgBkh2WInl5vL2xq4OzYR6X3QVdpSTyM3QlTmgE4h6ae5n9xL4Bqp4nte0HHpsOBoDINA247pIyhWoU2W4NcFr0OTmoC", ApiContext.Mode.TEST);
        Instamojo api = new InstamojoImpl(context);
        PaymentOrder order = new PaymentOrder();
        order.setName("John Smith");
        order.setEmail("john.smith@gmail.com");
        order.setPhone("9990429023");
        order.setCurrency("INR");
        order.setAmount(9D);
        order.setDescription("This is a test transaction.");
        order.setRedirectUrl("https://wise-lionfish-49.serverless.social/Josh_war_exploded/payment/success");
        order.setWebhookUrl("https://wise-lionfish-49.serverless.social/Josh_war_exploded/payment/success");
        order.setTransactionId("dxK234KKLLMOPkIKlMNiopklzk7q8IJK3Q");
        try {
           PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
            System.out.println("response " + paymentOrderResponse.getPaymentOrder().getStatus());
            System.out.println("response 2" + paymentOrderResponse.getPaymentOrder().toString());
            System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,"+paymentOrderResponse.getPaymentOptions().getPaymentUrl());

            response.sendRedirect(paymentOrderResponse.getPaymentOptions().getPaymentUrl());

            // print the status of the payment order.

            System.out.println("response..."+paymentOrderResponse.getPaymentOrder().getStatus());
        } catch (HTTPException e) {
            System.out.println("stackCode " + e.getStatusCode());
            System.out.println("JsonPayLoad " + e.getJsonPayload());
            System.out.println("statusCode " + e.getMessage());
            System.out.println("stackTrace " + Arrays.toString(e.getStackTrace()));
        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "home";
    }
}
