package com.epam.demo.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class LoggerService {

    private static final Logger log = Logger.getLogger(LoggerService.class);

   public void refill(Long number_card, BigDecimal value){
       try{
           log.info("Пополнение " + number_card + " на " + value.intValue());
       }
       catch (Exception e){
           log.error("Неизвестная ошибка при логирование пополнения") ;
       }
   }

   public void transfer(Long from,Long to, BigDecimal value){
       try{
           log.info("Перевод от "+ from + " к " + to + " на сумму "+ value.intValue());
       }
       catch (Exception e){
           log.error("Неизвестная ошибка при логировании перевода");
       }
   }

    public void blocking(Long number_card){
        try{
            log.info("Пользователь " + number_card + " заблокировал счёт");
        }
        catch (Exception e){
            log.error("Неизвестная ошибка при логировании блокировки");
        }
    }

}
