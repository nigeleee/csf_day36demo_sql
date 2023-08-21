export interface Orders {
  name: string,
  email: string,
  express: boolean,
  lineItems: LineItems[]
}

export interface LineItems {
  name: string,
  quantity: number,
  unit_price: number

}
