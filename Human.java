class Human extends Player {
        public Human(String username, char symbol) {
            super(username, symbol);
        }
    
        @Override
        public void play() {
            System.out.println(getUsername() + " is playing.");
        }
    }
    
