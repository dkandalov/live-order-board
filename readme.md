See `Silver Bars-v3.1.pdf` for task description. 

Since the task description doesn't have a lot of context I prefer to imagine that the task description
is some internal email which can be followed up by actually meeting the UI team and having a chat.
Therefore, the main goal of the implementation is to keep it as minimal and as simple as possible before all the details are clarified.

Some questions for the "meeting":
- Should we use terminology from the task description (e.g. `LiveOrderBoard`, `register`, `cancel`), or something more standard like `OrderBook`?
- It's not 100% clear what "5.5 kg for £306 // order a + order d" means,
  i.e. should the summary row include orders from which it was created or not?
- Overall architecture
    - data flow, amount of data/users, etc.
    - authentication/authorisation
    - input/output validation (error states, e.g. cancelling non-existent order)
    - threading in UI
- Is there need for API documentation?
- How UI team works in terms of releases? How would they prefer to consume the library?


Some assumptions:
- Quantity is always `kg`
- Prices are only in `GBP` per `kg` and can be represented as `int` for now
- No need for order history
- Ignore logging/traceability for now
