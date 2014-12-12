package itwise.broadleafcommerce.coupon.dao;

import itwise.broadleafcommerce.coupon.domain.Coupon;
import itwise.broadleafcommerce.coupon.domain.CustomerCoupon;

import java.util.List;

public interface CouponDao {

	List<Coupon> readCouponsForCustomer(Long customerId);
	List<Coupon> readCouponsForDownload();
	Coupon readCouponByCouponId(String couponId);

	void download(CustomerCoupon customerCoupon);

	void doApplyCoupon2Item(Long customerId, String couponId, Long orderItemId);
	void doApplyCoupon2Order(Long customerId, String couponId, Long orderId);
	void doApplyCoupon2Fulfillment(Long customerId, String couponId, Long orderId);
}
