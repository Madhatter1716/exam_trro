package com.interview.metrobank.enumerated;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
@Component
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {

	@Override
	public String convertToDatabaseColumn(AccountType attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getType();
	}

	@Override
	public AccountType convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return Stream.of(AccountType.values()).filter(value -> value.getType().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
