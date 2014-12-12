package itwise.broadleafcommerce.coupon.service;

import itwise.broadleafcommerce.coupon.domain.Coupon;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;


public interface CouponService {
	public List<Coupon> findCouponsForCustomer(Customer customer);

	public Boolean downloadCoupon(Customer customer, String couponId);

	public List<Coupon> findCouponForDownload();

	public Coupon findCouponByCouponId(String couponId);
}
