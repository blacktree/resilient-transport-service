package de.codecentric.resilient.booking.mapper;

import org.springframework.stereotype.Component;
import de.codecentric.resilient.booking.entity.Address;
import de.codecentric.resilient.booking.entity.Booking;
import de.codecentric.resilient.booking.entity.Customer;
import de.codecentric.resilient.dto.AddressDTO;
import de.codecentric.resilient.dto.BookingServiceRequestDTO;
import de.codecentric.resilient.dto.CustomerDTO;

/**
 * @author Benjamin Wilms (xd98870)
 */
@Component
public class BookingMapper {

    public Booking mapToBookingEntity(BookingServiceRequestDTO bookingRequestDTO, Long connote) {
        Booking booking = new Booking();
        booking.setConnote(connote);
        booking.setReceiverAddress(mapToAddressEntity(bookingRequestDTO.getReceiverAddress()));
        booking.setSenderAddress(mapToAddressEntity(bookingRequestDTO.getSenderAddress()));
        booking.setCustomer(mapToCustomer(bookingRequestDTO.getCustomerDTO()));

        return booking;
    }

    public Customer mapToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerId(customerDTO.getCustomerId());

        return customer;
    }

    public Address mapToAddressEntity(AddressDTO addressDTO) {

        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCountry(addressDTO.getCountry());
        address.setPostcode(addressDTO.getPostcode());
        address.setCity(addressDTO.getCity());
        address.setStreetNumber(addressDTO.getStreetNumber());
        return address;
    }
}
