package itwise.broadleafcommerce.coupon.controller;

import itwise.broadleafcommerce.coupon.domain.Coupon;
import itwise.broadleafcommerce.coupon.service.CouponService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.broadleafcommerce.common.util.BLCMessageUtils;
import org.broadleafcommerce.common.web.controller.BroadleafAbstractController;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.exception.IllegalCartOperationException;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.service.UpdateCartService;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;


public class BroadleafCouponController extends BroadleafAbstractController{

	@Resource(name = "blCatalogService")
	protected CatalogService catalogService;
	
	@Resource(name = "blOrderService")
	protected OrderService orderService;
	
	@Resource(name = "blOfferService")
	protected OfferService offerService;

	@Resource(name="blUpdateCartService")
	protected UpdateCartService updateCartService;

	@Resource(name = "blOrderToPaymentRequestDTOService")
	protected OrderToPaymentRequestDTOService dtoTranslationService;

	@Resource(name = "blCouponService")
	protected CouponService couponService;
	
	private static String couponDetailView = "coupon/coupon";
	private static String couponListView = "coupon/coupon";
	private static String couponPageRedirect = "redirect:/coupon";
	
	/**
	 * 
	 */
	public BroadleafCouponController() {
		
	}

	/**
	 * Render Coupon Page
	 * TODO: Change PricingException -> CouponException
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws PricingException
	 */
	public String availableDownload(HttpServletRequest request, HttpServletResponse response, Model model) throws PricingException {
		List<Coupon> coupons = couponService.findCouponForDownload();
		model.addAttribute("coupons", coupons);
		return getCouponListView();
	}

	private String getCouponListView() {
		return this.couponListView;
	}

	/**
	 * 
	 * 
	 * @return the couponView
	 */
	public static String getCouponDetailView() {
		return couponDetailView;
	}

	/**
	 * @return the couponPageRedirect
	 */
	public static String getCouponPageRedirect() {
		return couponPageRedirect;
	}
	
	/**
	 * TODO CouponOperationException Define 해야함
	 * 
	 * @param ex
	 * @return
	 */
	public Map<String, String> handleIllegalCartOpException(IllegalCartOperationException ex) {
		Map<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("error", "illegalCartOperation");
		returnMap.put("exception", BLCMessageUtils.getMessage(ex.getType()));
		return returnMap;
	}

	@ResponseBody
	public String doDownload(HttpServletRequest request, HttpServletResponse response, String couponId) throws PricingException {
		
		Coupon coupon = couponService.findCouponByCouponId(couponId);
        if (coupon == null) {
            throw new IllegalArgumentException("The Coupon provided is not valid");
        }
        
		if(couponService.downloadCoupon(CustomerState.getCustomer(), couponId)){
			return "redirect: /coupons";
		}
		return "redirect: /coupons";
	}
}
