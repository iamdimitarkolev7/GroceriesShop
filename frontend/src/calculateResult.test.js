import { calculateResult } from './utils/calculateResult';

describe('calculateResult', () => {
  it('should calculate the correct result for two for three deal', () => {
    const basketProducts = [
      { deal: 'TWO_FOR_THREE', name: 'potato', price: 10 },
      { deal: 'TWO_FOR_THREE', name: 'tomato', price: 20 },
      { deal: 'TWO_FOR_THREE', name: 'cucumber', price: 30 },
    ];

    const result = calculateResult(basketProducts);

    expect(result).toBe(50);
  });

  it('should calculate the correct result for buy one get one half price deal', () => {
    const basketProducts = [
      { deal: 'BUY_ONE_GET_ONE_HALF_PRICE', name: 'Product1', price: 20 },
      { deal: 'BUY_ONE_GET_ONE_HALF_PRICE', name: 'Product2', price: 30 },
      { deal: 'BUY_ONE_GET_ONE_HALF_PRICE', name: 'Product1', price: 20 },
    ];

    const result = calculateResult(basketProducts);

    expect(result).toBe(60);
  });
});