import { createBrowserRouter } from "react-router-dom";
import { ProductScreen } from "./product";
import {DevelopmentScreen} from './routing/DevelopmentScreen'

const router = createBrowserRouter([
  {
    path: "/",
    element: <ProductScreen />,
  },
  {
    path: "/products",
    element: <ProductScreen />,
  },
  {
    path: "/dev",
    element: <DevelopmentScreen/>
  }
]);

export { router };
