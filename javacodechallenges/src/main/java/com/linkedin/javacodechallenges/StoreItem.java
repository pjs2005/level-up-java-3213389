package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Comparator;
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
    return items.stream().min(Comparator.comparing(StoreItem::calculatePrice));
  }

  public static Optional<StoreItem> findCheaperst(Collection<StoreItem> items) {
    return items.stream().min(Comparator.comparing(StoreItem::getRRP));
  }

  private double calculatePrice() {
    return retailPrice - (retailPrice * discount);
  }

  private double getRRP() {
    return retailPrice;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }

  public String display() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice;
  }
}