package itwise.broadleafcommerce.coupon.service;

import itwise.broadleafcommerce.coupon.dao.CouponDao;
import itwise.broadleafcommerce.coupon.domain.Coupon;
import itwise.broadleafcommerce.coupon.domain.CouponImpl;
import itwise.broadleafcommerce.coupon.domain.CustomerCoupon;
import itwise.broadleafcommerce.coupon.domain.CustomerCouponImpl;

import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.service.OfferServiceImpl;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.springframework.stereotype.Service;


@Service("blCouponService")
public class CouponServiceImpl extends OfferServiceImpl implements CouponService {
	@Resource(name = "blCouponDao")
	protected CouponDao couponDao;
	
	@Resource(name = "blOrderDao")
	protected OrderDao orderDao;
	
	@Resource(name = "blOfferDao")
	protected OfferDao offerDao;

	@Override
	public List<Coupon> findCouponsForCustomer(Customer customer) {
		return couponDao.readCouponsForCustomer(customer.getId());
	}

	@Override
	public Boolean downloadCoupon(Customer customer, String couponId) {
		CustomerCoupon customerCoupon = new CustomerCouponImpl();
		customerCoupon.setCustomer(customer);
		Coupon coupon = new CouponImpl();
		customerCoupon.setCoupon(coupon);
		
		couponDao.download(customerCoupon);
		return true;
	}

	@Override
	public List<Coupon> findCouponForDownload() {
		return couponDao.readCouponsForDownload();
	}

	@Override
	public Coupon findCouponByCouponId(String couponId) {
		return couponDao.readCouponByCouponId(couponId);
	}
}
