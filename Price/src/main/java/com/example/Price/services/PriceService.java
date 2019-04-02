package com.example.Price.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Price.domain.Price;
import com.example.Price.domain.Product;
import com.example.Price.domain.ProductInfo;
import com.example.Price.domain.ProductList;

@Service
public class PriceService {

	@Autowired
	ProductService productService;

	class SortbyDiscount implements Comparator<ProductInfo> {
		public int compare(ProductInfo a, ProductInfo b) {
			return Float.compare(b.getDiscountAmount(), a.getDiscountAmount());
		}
	}

	public ArrayList<Product> getProduct(String labelType) {
		ArrayList<Product> products = new ArrayList<Product>();
		ProductList productList;
		productList = productService.ProductFromStream();

		ArrayList<ProductInfo> productInfos = productList.getProducts();
		productInfos.sort(new SortbyDiscount());

		for (ProductInfo productInfo : productInfos) {

			if (!productInfo.getPrice().getWas().isEmpty()) {
				Product p = new Product();
				p.setProductId(productInfo.getProductId());
				p.setTitle(productInfo.getTitle());

				p.setColorSwatches(productInfo.getColorSwatches());

				p.setNowPrice(getCurrenyCode(productInfo.getPrice().getCurrency())
						+ moneyFormat(productInfo.getPrice().getNow().getTo()));

				p.setPriceLabel(getPriceLabelText(productInfo.getPrice(), labelType));

				products.add(p);
			}
		}

		return products;

	}

	private String getCurrenyCode(String currency) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("GBP", "£");
		hmap.put("USD", "$");
		hmap.put("EUR", "€");
		return hmap.get(currency);
	}

	private String moneyFormat(String price) {
		String formattedMoney = null;

		if (!price.isEmpty()) {
			if (Float.parseFloat(price) >= 10) {
				formattedMoney = Integer.toString(Math.round(Float.parseFloat(price)));

			} else {
				formattedMoney = BigDecimal.valueOf(Float.parseFloat(price)).setScale(2, BigDecimal.ROUND_HALF_UP)
						.toString();

			}

		}

		return formattedMoney;

	}

	private String getPriceLabelText(Price price, String labelType) {
		String retText = null;
		if (labelType.equals("ShowWasNow")) {
			retText = "Was " + getCurrenyCode(price.getCurrency()) + moneyFormat(price.getWas()) + " Now "
					+ getCurrenyCode(price.getCurrency()) + moneyFormat(price.getNow().getTo());

		} else if (labelType.equals("ShowWasThenNow"))

		{
			retText = "Was " + getCurrenyCode(price.getCurrency()) + moneyFormat(price.getWas());

			String then = Optional.ofNullable(price.getThen2()).orElse(price.getThen1());
			if (!then.isEmpty()) {
				retText = retText + "Then " + getCurrenyCode(price.getCurrency()) + moneyFormat(then);
			}

			retText = retText + " Now " + getCurrenyCode(price.getCurrency()) + moneyFormat(price.getNow().getTo());

		} else if (labelType.equals("ShowPrcDscount")) {

			float was = Float.parseFloat(price.getWas());
			float now = Float.parseFloat(price.getNow().getTo());
			String disc = BigDecimal.valueOf(100 * (1 - now / was)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();

			retText = "%" + disc + " Off - Now " + getCurrenyCode(price.getCurrency())
					+ moneyFormat(price.getNow().getTo());
		}

		return retText;
	}

}
