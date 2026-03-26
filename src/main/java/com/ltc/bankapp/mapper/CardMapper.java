package com.ltc.bankapp.mapper;

import com.ltc.bankapp.dto.card.CardRequestDto;
import com.ltc.bankapp.dto.card.CardResponseDto;
import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public Card toEntity(CardRequestDto cardRequestDto, Account account){

        if (cardRequestDto == null || account == null){
            return null;
        }

        Card card = new Card();

        card.setCardNumber(cardRequestDto.getCardNumber());
        card.setCardType(cardRequestDto.getCardType());
        card.setExpirationDate(cardRequestDto.getExpirationDate());
        card.setActive(true); // new card should be active by default
        card.setAccount(account);

        return card;
    }

    public CardResponseDto toDto(Card card){

        if (card == null){
            return null;
        }

        return new CardResponseDto(
                card.getId(),
                card.getCardNumber(),
                card.getCardType(),
                card.getExpirationDate(),
                card.isActive(),
                card.getAccount().getId()
        );
    }

    //  card is not updated commonly
    //  activate / deactivate or block / unblock

}