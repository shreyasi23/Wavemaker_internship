describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://www.amazon.in/s?k=boat+bassheads+105+wired+earphones&crid=2U6JGRCM3F56F&sprefix=%2Caps%2C219&ref=nb_sb_ss_recent_1_0_recent');
    cy.get('boAt Bassheads 105 Wired in Ear Earphones with Mic (Blue)').click();
  })
})