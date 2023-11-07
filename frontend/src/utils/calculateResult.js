export const calculateResult = (basketProducts) => {
  
  let result = 0;
  
  let twoForThreeArray = [];
  let buyOneGetOneObj = {};

  for (const product of basketProducts) {
    switch (product.deal) {
      case 'TWO_FOR_THREE':
        twoForThreeArray.push(product);
        if (twoForThreeArray.length === 3) {
          twoForThreeArray.sort((a, b) => b.price - a.price);
          result += twoForThreeArray[0].price + twoForThreeArray[1].price;
          twoForThreeArray = [];
        }
        break;
      case 'BUY_ONE_GET_ONE_HALF_PRICE':
        if (!buyOneGetOneObj[product.name]) {
          buyOneGetOneObj[product.name] = product.price;
        } else {
          result += 1.5 * product.price;
          delete buyOneGetOneObj[product.name];
        }
        break;
      default:
        console.log('Error: Unknown deal type');
        break;
    }
  }

  result += twoForThreeArray.reduce((acc, current) => acc + current.price, 0);
  result += Object.keys(buyOneGetOneObj).reduce((acc, current) => acc + parseFloat(buyOneGetOneObj[current]), 0);

  return result;
};
