package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
    // TODO: Implement
    Collection<StoreItem> calculatedItems = items
        .stream().map(item -> {
          String name = item.getName();
          Double newPrice = item.getRetailPrice() * (1 - item.getDiscount());

          return new StoreItem(name, newPrice, 0);
        }).toList();
    calculatedItems.stream().forEach(item -> System.out.println(item.display()));
    return calculatedItems.stream().sorted((o1, o2) -> {
      if (o1.getRetailPrice() < o2.getRetailPrice()) {
        return -1;
      } else if (o1.getRetailPrice() > o2.getRetailPrice()) {
        return 1;
      } else {
        return 0;
      }
    }).findFirst();
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }

  public String display() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice;
  }
}