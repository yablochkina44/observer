public interface ITerminal {
    void registerObserver(Observer var);
    void deleteObserver(Observer var);
    void alertObservers();
}